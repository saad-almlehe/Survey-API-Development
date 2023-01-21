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

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Service
public class ResponseSerivcempl implements ResponseSerivce {


    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private QuestionRepository questionRepository;




    public List<Response> retrieveSuervyResponse(Long id) throws NotFoundException {

        if(responseRepository.findResponseSuervy(id) != null)
            return responseRepository.findResponseSuervy(id);
        else throw new NotFoundException("no response stored");

    }

    public  ResponseEntity<Object> DeleteResponseById(Long responseID) throws NotFoundException {
        if(responseRepository.findById(responseID) != null){
            responseRepository.deleteById(responseID);
            HashMap<String, Object> map = new HashMap<>();
            map.put("Message","response has been deleted with ID of"+ responseID);
            map.put("timestamp", LocalDateTime.now());
            return new ResponseEntity<>(map , HttpStatus.OK);
        } else throw new NotFoundException("question not found with ID "+responseID);
    }

    public ResponseEntity<Object> addnewResponse(Long id, Response response) throws NotFoundException {

        if(responseRepository.findSuervyByid(id) != null){
            if(checkSuervyAvailibialty(responseRepository.findSuervyByid(id))) {
                List<Question> question = questionRepository.findQuestionsSuervy(id);

                if (checkResponse(response, question)) {
                    responseRepository.save(response);
                    responseRepository.addResponseTosuervy(id, response.getId());
                } else return new ResponseEntity<>("mandatory field is missing " , HttpStatus.BAD_REQUEST);


            } else {
                HashMap<String, Object> map = new HashMap<>();
                map.put("Message","Survey with ID "+ id +" is not accepting more responses ");
                map.put("timestamp", LocalDateTime.now());
                return new ResponseEntity<>(map , HttpStatus.BAD_REQUEST);
            }

        } else throw new NotFoundException("Survey not found with ID "+id);


        HashMap<String, Object> map = new HashMap<>();
        map.put("Message","response has been added to survey ID " +id+ " and the response ID is " +response.getId());
        map.put("timestamp", LocalDateTime.now());
        return new ResponseEntity<>(map , HttpStatus.CREATED);




    }

    public boolean checkSuervyAvailibialty(Survey suervyByid) {



        if(suervyByid.getMax_response() < responseRepository.findResponseSuervy(suervyByid.getId()).size()+1)
            return false;

        if(!suervyByid.getActive())
            return false;



        return true;

    }

    public boolean checkResponse ( Response response , List<Question> question){

        for (int i = 0; i < question.size(); i++) {
            //System.out.println("is the id "+question.get(i).getId()+" mandatory "+question.get(i).isMandatory());
            if(question.get(i).isMandatory()){
                if(!findcrossbondQuestion(response,question.get(i).getId()))
                   return false;
            }
        }

        return true;
    }


    public boolean findcrossbondQuestion ( Response response , Long questionID){

        if(response.getAnswers() != null) {

            for (int j = 0; j < response.getAnswers().size(); j++) {
                if(response.getAnswers().get(j).getQuestionID() == questionID)
                    return true;
            }
        }

        return false;
    }


}
