package com.SteshM.MainDella.utilities;

import com.SteshM.MainDella.DTO.ResponseDTO;

import java.util.List;

public class Utilities {

    public static ResponseDTO createSuccessfulResponse(String message,Object data){
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setStatusCode(200);
        responseDTO.setStatusDescription(message);
        responseDTO.setData(List.of(data));
        return responseDTO;
    }
}
