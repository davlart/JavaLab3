package humanResources;

/**
 * Created by ArthurArt on 13.03.2017.
 */
public abstract class Employee{
    private String ferstName;
    private String secondName;
    private String jobPosition;
    private int salary;
    private  final static String DEFAULT_JOB_POSITION = "";
    private  final static int DEFAULT_SALARY = 0;
    private int  bonus;
   protected   Employee(String ferstName,String secondName){
        this.ferstName = ferstName;
        this.secondName = secondName;
        this.jobPosition = DEFAULT_JOB_POSITION;
        this.salary = DEFAULT_SALARY;
    }
    protected  Employee(String ferstName,String secondName,String jobPosition,int salary){
       this(ferstName,secondName);
        this.jobPosition = jobPosition;
        this.salary = salary;
    }

    public void setFerstName(String ferstName){
        this.ferstName = ferstName;
    }
    public String getFerstName(){
        return ferstName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public String getSecondName(){
        return secondName;
    }

    public void setJobPosition(String jobPosition){
        this.jobPosition = jobPosition;
    }

    public String getJobPosition(){
        return jobPosition;
    }

    public void setSalary(int salary){
        this.salary =salary;
    }

    public int getSalary(){
        return salary;}

        public String toString()
        {
          String bufStr = (ferstName.isEmpty()?"":ferstName)  +" "+
                  (secondName.isEmpty()?"":secondName) + " "+
                  (jobPosition.isEmpty()?"":jobPosition) +" " +
                  (salary==0?"":salary);


             return  bufStr;
        }
    public boolean equals(Object obj){
      return  true;
    }

        protected abstract void  setBonus(int bonus);

        protected  abstract int getBonus();
}