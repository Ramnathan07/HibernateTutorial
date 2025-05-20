package org.example;



import jakarta.persistence.*;

import java.util.List;

@Entity
//@Entity(name = "e_name");     this will change entity name
//@Table(name = "e_name");      this will change table name
public class employee {

//    @Column(name = "e_name")          this will change column name
    @Id
    private int eid;
    private String ename;
    private String stack;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptops;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "employee{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", stack='" + stack + '\'' +
                ", laptops=" + laptops +
                '}';
    }



    //Exmaple for one to one
    //    @OneToOne
//    private Laptop lap;
    //    public Laptop getLap() {
//        return lap;
//    }
//
//    public void setLap(Laptop lap) {
//        this.lap = lap;
//    }
//
//    @Override
//    public String toString() {
//        return "employee{" +
////                "eid=" + eid +
////                ", ename='" + ename + '\'' +
////                ", stack='" + stack + '\'' +
////                ", lap=" + lap +
////                '}';
////    }
}
