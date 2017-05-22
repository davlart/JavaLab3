package humanResources;

/**
 * Created by ArthurArt on 13.03.2017.
 */
 abstract class Employee{
    private String firstName;
    private String secondName;
    private JobTitlesEnum jobTitle;
    private int salary;
    private  final static String DEFAULT_JOB_POSITION = "";
    private  final static int DEFAULT_SALARY = 0;
    private int  bonus;
   protected     Employee(String firstName,String secondName){
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = JobTitlesEnum.NONE;
        this.salary = DEFAULT_SALARY;
    }
    protected Employee(String firstName,String secondName,JobTitlesEnum jobTitle,int salary){
       this(firstName,secondName);
        this.jobTitle = JobTitlesEnum.NONE;
        this.salary = salary;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }

    public String getSecondName(){
        return secondName;
    }

    public void setJobTitle(JobTitlesEnum jobTitle){
        this.jobTitle = jobTitle;
    }

    public JobTitlesEnum getJobTitle(){
        return jobTitle;
    }

    public void setSalary(int salary){
        this.salary =salary;
    }

    public int getSalary(){
        return salary;}

        public String toString()
        {
            return (firstName.isEmpty()?"":firstName)  +" "+
                  (secondName.isEmpty()?"":secondName) + " "+
                  (jobTitle.equals(JobTitlesEnum.NONE)?"":jobTitle) +" " +
                  (salary==0?"":salary);


        }


        protected abstract void  setBonus(int bonus);

        protected  abstract int getBonus();

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;

        if(getClass()!=obj.getClass())
            return  false;
            Employee otherObj = (Employee) obj;
            if ((this.getFirstName() == otherObj.getFirstName()) && (this.getSecondName() == otherObj.getSecondName())
                    && (this.getSalary() == otherObj.getSalary()) && (this.getJobTitle() == otherObj.getJobTitle()))
                return true;

        return false;
    }

    public int hashCode() {
        return getFirstName().hashCode()^getSecondName().hashCode();
    }





}