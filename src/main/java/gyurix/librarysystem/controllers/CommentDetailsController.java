package gyurix.librarysystem.controllers;

import gyurix.librarysystem.SOAPConnector;
import gyurix.librarysystem.models.CommentDetailModel;
import gyurix.librarysystem.services.comment.Comment;
import gyurix.librarysystem.services.comment.Komentar;
import gyurix.librarysystem.services.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.net.httpserver.HttpsServerImpl;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommentDetailsController {
    public static final String COMMENT_DETAIL_PATH = "/detailComment";
    public static final String DELETE_COMMENT_PATH = "/deleteComment";
    public static final String CONFIRM_COMMENT_PATH = "/detailConfirmComment";
    public static final String COMMENT_DETAIL_HTML = "commentsDetails";

    public static final String COMMENT_ID_PARAMETER = "commentId";
    public static final String DEFAULT_COMMENT_ID = "-1";

    public static final String COMMENT_LIST_ATTRIB = "commentList";

    public static final String TITLE_ATTRIB = "title";

    @RequestMapping(COMMENT_DETAIL_PATH)
    public String showDetails(HttpSession session, Model model, @RequestParam(name = COMMENT_ID_PARAMETER, defaultValue = DEFAULT_COMMENT_ID) String commentId) {
        Comment comment = SOAPConnector.instance.getCommentById(Integer.parseInt(commentId));
        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        model.addAttribute(TITLE_ATTRIB, "Detail komentaru");
        model.addAttribute(COMMENT_LIST_ATTRIB, commentList);
        model.addAttribute(COMMENT_ID_PARAMETER, commentId);


        return COMMENT_DETAIL_HTML;
    }

    @RequestMapping(params = "delete", method = RequestMethod.POST, value = COMMENT_DETAIL_PATH)
    public String deleteComment(
            HttpSession session,
            Model model,
            @RequestParam(name = COMMENT_ID_PARAMETER, defaultValue = DEFAULT_COMMENT_ID) String commentId,
            @ModelAttribute(CommentDetailModel.MODEL_ATTRIB) CommentDetailModel cdm) {
        String adminResponse = cdm.getAdminResponse();
        Comment comment = SOAPConnector.instance.getCommentById(Integer.parseInt(commentId));
        User user = SOAPConnector.instance.getUserById(comment.getUserID()).getUser();
        SOAPConnector.instance.sendCommentDeleteNotify(user, comment, adminResponse);
        SOAPConnector.instance.deleteComment(Integer.parseInt(commentId));
        List<Comment> listOfComments = SOAPConnector.instance.getUnsolvedComments();
        model.addAttribute("commentList", listOfComments);

        return AdminController.UNSOLVED_COMMENTS_LIST_HTML;
    }

    @RequestMapping(params = "submit", method = RequestMethod.POST, value = COMMENT_DETAIL_PATH)
    public String confirmComment(
            HttpSession session,
            Model model,
            @RequestParam(name = COMMENT_ID_PARAMETER, defaultValue =  DEFAULT_COMMENT_ID) String commentId,
            @ModelAttribute(CommentDetailModel.MODEL_ATTRIB) CommentDetailModel cdm) {
        String adminResponse = cdm.getAdminResponse();
        Comment comment = SOAPConnector.instance.getCommentById(Integer.parseInt(commentId));
        User user = SOAPConnector.instance.getUserById(comment.getUserID()).getUser();

        Komentar komentar = new Komentar();
        komentar.setAccepted(true);
        komentar.setAcceptedDate(comment.getAcceptedDate());
        komentar.setAddedDate(comment.getAddedDate());
        komentar.setBookId(comment.getBookId());
        komentar.setUserID(comment.getUserID());
        komentar.setId(comment.getId());
        komentar.setName(comment.getName());
        komentar.setRating(comment.getRating());
        komentar.setReviewerNote(adminResponse);
        komentar.setSpoiler(false);
        komentar.setText(comment.getText());
        SOAPConnector.instance.updateComment(komentar, comment.getId());
        SOAPConnector.instance.sendCommentAcceptNotify(user, comment);

        List<Comment> commentList = SOAPConnector.instance.getUnsolvedComments();
        model.addAttribute(COMMENT_LIST_ATTRIB, commentList);

        return AdminController.UNSOLVED_COMMENTS_LIST_HTML;
    }
}