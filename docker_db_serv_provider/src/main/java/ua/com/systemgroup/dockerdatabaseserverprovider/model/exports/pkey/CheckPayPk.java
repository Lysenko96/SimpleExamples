package ua.com.systemgroup.dockerdatabaseserverprovider.model.exports.pkey;

import lombok.Data;

@Data
public class CheckPayPk {

    private Short idShop;
    private Integer idWorkplace;
    private Integer idCheck;
    private Integer pos;
}
