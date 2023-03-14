/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author nguye
 */
public class Questions {
    
    private String ID, Question, Answ1, Answ2, Answ3 ,Answ4, Result;

    public String getID() {
        return ID;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAnsw1() {
        return Answ1;
    }

    public String getAnsw2() {
        return Answ2;
    }

    public String getAnsw3() {
        return Answ3;
    }

    public String getAnsw4() {
        return Answ4;
    }

    public String getResult() {
        return Result;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setQuestion(String Question) {
        this.Question = Question;
    }

    public void setAnsw1(String Answ1) {
        this.Answ1 = Answ1;
    }

    public void setAnsw2(String Answ2) {
        this.Answ2 = Answ2;
    }

    public void setAnsw3(String Answ3) {
        this.Answ3 = Answ3;
    }

    public void setAnsw4(String Answ4) {
        this.Answ4 = Answ4;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public Questions() {
    }

    public Questions(String ID, String Question, String Answ1, String Answ2, String Answ3, String Answ4, String Result) {
        this.ID = ID;
        this.Question = Question;
        this.Answ1 = Answ1;
        this.Answ2 = Answ2;
        this.Answ3 = Answ3;
        this.Answ4 = Answ4;
        this.Result = Result;
    }
    
    
    
    
}
