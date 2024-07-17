package org.example.externalizable;

import java.io.*;

public class SubMyClass extends MyClass
//        implements Serializable
        implements Externalizable
{

    private Integer subId;
    private String subName;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(getId());
        out.writeUTF(getName());
        out.writeInt(getSubId());
        out.writeUTF(getSubName());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setId(in.readInt());
        setName(in.readUTF());
        setSubId(in.readInt());
        setSubName(in.readUTF());
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "SubMyClass{" +
                "subId=" + subId +
                ", subName='" + subName + '\'' +
//                "id=" + id +
//                ", name='" + name + '\'' +
                '}';
    }
}
