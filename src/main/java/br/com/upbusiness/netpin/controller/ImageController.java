//package br.com.upbusiness.netpin.controller;
//
//import br.com.upbusiness.netpin.domain.Image;
//import br.com.upbusiness.netpin.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Base64;
//
//@Controller
//public class ImageController {
//
//    @Autowired
//    private ImageService imageService;
//
//    @PostMapping("/image/add")
//    public String addImage(@RequestParam("title") String title,
//                           @RequestParam("image") MultipartFile image, Model model)
//            throws IOException {
//        String id = imageService.addImage(title, image);
//        return "redirect:/image/" + id;
//    }
//
//    @GetMapping("/image/{id}")
//    public String getImage(@PathVariable String id, Model model) {
//
//        Image image = imageService.getImage(id);
//        model.addAttribute("title", image.getTitle());
//        model.addAttribute("image",
//                Base64.getEncoder().encodeToString(image.getImage().getData()));
//        return "image";
//    }
//}
