package com.joel_lucas_thibault.overlook_hotel;

//import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommentController {

    //private final RoomService roomService;

    //public RoomController(RoomService roomService) {
    //    this.roomService = roomService;
    //}

    @GetMapping("/comment")
    public String showComments(Model model) {
        //List<Comment> comments = commentService.getAllComments();
        //model.addAttribute("comments", comments);
        return "comment";
    }
}