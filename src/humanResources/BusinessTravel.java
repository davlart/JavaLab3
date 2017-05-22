package humanResources;

/**
 * Created by ArthurArt on 23.04.2017.
 */
public final class BusinessTravel {
    private  int compensation;
    private  int daysCount;
    private  String description;
    private  String destination;
    private final int DEFAULT_COUNT = 0;
    private final String DEFAULT_STRING = "";

     //public BusinessTravel(){this(DEFAULT_COUNT,DEFAULT_COUNT,DEFAULT_STRING,DEFAULT_STRING);    }

    public BusinessTravel(int compensation,int daysCount,String description,String destination){
        this.compensation=compensation;
        this.daysCount=daysCount;
        this.description=description;
        this.destination=destination;
    }


    public int getCompensation(){
        return compensation;
    }
    public int getDaysCount(){
        return daysCount;
    }
    public String getDescription(){
        return description;
    }
    public String getDestination(){
        return destination;
    }



    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        // проверка на случай, если сравнение с самим собой
        if (obj == this)
            return true;
       if(getClass()!=obj.getClass())
           return false;
        BusinessTravel otherObj = (BusinessTravel)obj;
        if(( this.getCompensation()==otherObj.getCompensation())&&(this.getDaysCount()==otherObj.getDaysCount())
                &&(this.getDescription()==otherObj.getDescription())&&(this.getDestination()==otherObj.getDestination()))
            return  true;

        return false;
    }

    public String toString()
    {
        return ( getDestination().isEmpty()?"": getDestination())  +" "+
                ( getDaysCount()==0?"": getDaysCount()) + " "+
                ( getCompensation()==0?"": getCompensation()) +" " +
                ( getDescription().isEmpty()?"": getDescription());



    }


    public int hashCode() {
        return getDestination().hashCode()^getDescription().hashCode()^getCompensation()^getDaysCount();
    }


}
