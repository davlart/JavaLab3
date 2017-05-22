package humanResources;

/**
 * Created by ArthurArt on 23.04.2017.
 */
   public class StaffEmployee extends Employee implements BusinessTraveller {
    private static final int  DEFAULT_COUNT = 0;
    private int bonus;
    private LinkedCyclingList<BusinessTravel> list;
   private int travelsQuantity;

   private final int DEFAULT_SALARY = 0;




   public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, int salary) {
        super(firstName, secondName, jobTitle, salary);
       this.bonus = DEFAULT_COUNT;

   }

    public StaffEmployee(String firstName, String secondName) {
        super(firstName, secondName);
        this.bonus = DEFAULT_COUNT;
    }


    public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, int Salary, BusinessTravel[] businessTravels) {
        super(firstName, secondName, jobTitle, Salary);
        bonus = DEFAULT_COUNT;

        list = new LinkedCyclingList<>();
        list.addAll(businessTravels);
    }






    @Override
    protected void setBonus(int bonus) {
       this.bonus = bonus;
    }

    @Override
    protected int getBonus() {
        return bonus;
    }

    @Override
    public void addTravel(BusinessTravel businessTravel) {
        list.add(businessTravel);
    }
    public int getTravelQuantity(){
        return list.count();
    }
    @Override
    public BusinessTravel[] getBusinessTravel() {
        BusinessTravel[] businessTravel = new BusinessTravel[list.count()];

        for(int i=0;i<list.count();i++){
            businessTravel[i] = list.next();
        }
        list.reset();
        return businessTravel;
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append((getSecondName().isEmpty() ? "" : getSecondName()) + " " + (getFirstName().isEmpty() ? "" : getFirstName()) +
                " " +
                ((getJobTitle().equals(JobTitlesEnum.NONE)) ? "" : getJobTitle()) + " " +
                ((getSalary() == 0) ? "" : getSalary()) + " "  +
                ((getBonus() == 0) ? "" : getBonus()));
        for(BusinessTravel bt : getBusinessTravel()){
            s.append(bt.toString().isEmpty()?"":bt.toString());
        }
        return s.toString();
    }
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;

        if(getClass()!=obj.getClass())
            return  false;
        StaffEmployee otherObj = (StaffEmployee) obj;


        if(!otherObj.toString().equals(this.toString()) || getTravelQuantity() != getTravelQuantity())
            return false;
        return false;
    }


    @Override
    public int hashCode() {
        return super.hashCode() ^ bonus ^ list.hashCode();
    }
}
