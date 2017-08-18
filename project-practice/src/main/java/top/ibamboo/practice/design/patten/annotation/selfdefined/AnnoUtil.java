package top.ibamboo.practice.design.patten.annotation.selfdefined;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by C0907 on 2017/8/11.
 */
@Data
public class AnnoUtil implements Serializable{

    @SelfCreateAnnotation
    private static final long serialVersionUID = 1L;

    @SelfCreateAnnotation
    private  Integer researchId;

    @SelfCreateAnnotation
    private String userId;

    private String version;

    private String grade;

}