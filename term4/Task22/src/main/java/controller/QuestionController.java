package controller;

import model.Answer;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.QuestionService;

import java.math.BigInteger;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String getQuestion(@RequestParam( value = "id", required = false) BigInteger id, Model model) {
        if(id == null) {
            id = BigInteger.valueOf(1);
        }
        Question question = questionService.getQuestionById(id);
        if( question == null ) {
            return "redirect:/finish";
        }
        model.addAttribute("question", question);
        return "question";
    }

    @RequestMapping("/check")
    @ResponseBody
    public String check(@RequestParam BigInteger q_id, @RequestParam Long a_num) {
        List<Answer> answers = questionService.getQuestionById(q_id).getAnswers();
        if(a_num <= answers.size()) {
            return String.valueOf(answers.get(a_num.intValue() - 1).isCorrect());
        }
        return "Пожалуйста, перезагрузите страницу";
    }

    @RequestMapping("/finish")
    public String finish(Model model) {
        return "finish";
    }


}
