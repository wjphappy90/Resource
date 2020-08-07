package com.heima.cloneDemo.domain;

/**
 * @author 长沙黑马程序员
 * @since JDK 1.8
 */
public class Skill implements Cloneable{
    private String skillName;

    public Skill() {
    }

    public Skill(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "skillName='" + skillName + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
