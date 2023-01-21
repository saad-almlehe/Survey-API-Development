package com.task.surveyAPI.services;

import com.task.surveyAPI.Exception.NotFoundException;
import com.task.surveyAPI.entity.Question;
import com.task.surveyAPI.entity.Response;
import com.task.surveyAPI.entity.Survey;
import com.task.surveyAPI.repository.QuestionRepository;
import com.task.surveyAPI.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ResponseSerivcempl implements ResponseSerivce {


    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private QuestionRepository questionRepository;




    public List<Response> retrieveSuervyResponse(Long id) {

        return responseRepository.findResponseSuervy(id);
    }

    public ResponseEntity<Object> addnewResponse(Long id, Response response) throws NotFoundException {

        if(responseRepository.findSuervyByid(id) != null){
            if(checkSuervyAvailibialty(responseRepository.findSuervyByid(id))) {
                List<Question> question = questionRepository.findQuestionsSuervy(id);

                if (checkResponse(response, question)) {
                    responseRepository.save(response);
                    responseRepository.addResponseTosuervy(id, response.getId());
                }


            } else return new ResponseEntity<>("Survey with ID "+ id +" is not accepting more responses " , HttpStatus.OK);

        } else throw new NotFoundException("Survey not found with ID "+id);



             return new ResponseEntity<>("response has been added to survey ID "+id+" and the response ID is "+response.getId()  , HttpStatus.OK);


    }

    public boolean checkSuervyAvailibialty(Survey suervyByid) {


        System.out.println(responseRepository.findResponseSuervy(suervyByid.getId()).size());
        if(suervyByid.getMax_response() < responseRepository.findResponseSuervy(suervyByid.getId()).size()+1)
            return false;

        if(!suervyByid.getActive())
            return false;



        return true;

    }

    public boolean checkResponse ( Response response , List<Question> question){









        return true;
    }
}
