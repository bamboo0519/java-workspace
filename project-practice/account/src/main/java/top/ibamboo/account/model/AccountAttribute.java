package top.ibamboo.account.model;

import java.io.Serializable;

/**
 * Created by bamboo on 2017/10/19.
 */
public class AccountAttribute implements Serializable {
    Long id;
    String accoundId;
    String attributeName;
    String attributeValue;
    String gmtCreate;
    String gmtUpdate;
}
