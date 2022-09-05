package com.bridgelabz.addressbookappdevlopment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseDTO {
    private String message;
    private Object data;
    public ResponseDTO(String message, Object data) {
        super();
        this.message = message;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
