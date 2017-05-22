package humanResources;

/**
 * Created by ArthurArt on 23.04.2017.
 */
public class PartTimeEmployee extends Employee {

    private static final int DEFAULT_BONUS = 0;

    public PartTimeEmployee(String firstName, String secondName) {
        super(firstName, secondName);
    }
    public PartTimeEmployee(String firstName,String secondName,JobTitlesEnum jobPosition,int salary){
        super(firstName, secondName,jobPosition,salary);
    }

    @Override
    protected void setBonus(int bonus) {

    }

    @Override
    protected int getBonus() {
        return DEFAULT_BONUS;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;
        if(getClass()!=obj.getClass())
            return  false;
        PartTimeEmployee otherObj = (PartTimeEmployee)obj;
        if(( this.getFirstName()==otherObj.getFirstName())&&(this.getSecondName()==otherObj.getSecondName())
                &&(this.getSalary()==otherObj.getSalary())&&(this.getJobTitle()==otherObj.getJobTitle())
                 )
            return  true;

        return false;
    }

    public String toString()
    {


        return((getSecondName().isEmpty() ? "" : getSecondName()) + " " +
                (getFirstName().isEmpty() ? "" : getFirstName())  + " " +
                ((getJobTitle().equals(JobTitlesEnum.NONE)) ? "" : getJobTitle()) + " " +
                ((getSalary() == 0) ? "" : getSalary()) + " "  +
                ((getBonus() == 0) ? "" : getBonus()));








    }


    public int hashCode() {
      return  getFirstName().hashCode()^getSecondName().hashCode();
    }


}
