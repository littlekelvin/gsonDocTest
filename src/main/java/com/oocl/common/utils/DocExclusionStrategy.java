package com.oocl.common.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class DocExclusionStrategy implements ExclusionStrategy{
    private boolean skipManyToOneField;
    private boolean skipOneToOneField;
    private boolean skipManyToManyField;

    public DocExclusionStrategy(boolean skipManyToOneField, boolean skipIneToOneField, boolean skipManyToManyField) {
        this.skipManyToOneField = skipManyToOneField;
        this.skipOneToOneField = skipIneToOneField;
        this.skipManyToManyField = skipManyToManyField;
    }

    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        boolean flag = false;
        if(skipManyToOneField){
            flag = flag || (null != fieldAttributes.getAnnotation(ManyToOne.class));
        }
        if(skipOneToOneField){
            flag = flag || (null != fieldAttributes.getAnnotation(OneToOne.class));
        }
        if(skipManyToManyField){
            flag = flag || (null != fieldAttributes.getAnnotation(ManyToMany.class));
        }
        return flag;
    }

    public boolean shouldSkipClass(Class<?> aClass) {
        boolean flag = false;
        if(skipManyToOneField){
            flag = flag || (null != aClass.getAnnotation(ManyToOne.class));
        }
        if(skipOneToOneField){
            flag = flag || (null != aClass.getAnnotation(OneToOne.class));
        }
        if(skipManyToManyField){
            flag = flag || (null != aClass.getAnnotation(ManyToMany.class));
        }
        return flag;
    }
}
