package model;
import com.sun.org.apache.xpath.internal.operations.Equals;
import java.io.Serializable;


public class Meal implements Serializable
{
    private  int mId;
    private  String mName;
    private  String mCategory;
    private  double mPrice;
    private  int mPortion;
    private  String mDetails;
    private  String image;
    private  boolean isAdded;
    public Meal(){}

    public Meal(int mId, String mName, String mCategory, double mPrice, int mPortion, String mDetails, String image) {
        this.mId = mId;
        this.mName = mName;
        this.mCategory = mCategory;
        this.mPrice = mPrice;
        this.mPortion = mPortion;
        this.mDetails = mDetails;
        this.image=image;
    }

    public Meal(String mName, double mPrice ,String mCategory, String img , String det)
    {
        this.mPrice=mPrice;
        this.mName=mName;
        this.mCategory=mCategory;
        this.mDetails=det;
        this.image=img;
    }
   


    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCategory() {
        return mCategory;
    }

    public void setmCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public double getmPrice() {
        return mPrice;
    }

    public void setmPrice(double mPrice) {
        this.mPrice = mPrice;
    }

    public int getmPortion() {
        return mPortion;
    }

    public void setmPortion(int mPortion) {
        this.mPortion = mPortion;
    }

    public String getmDetails() {
        return mDetails;
    }

    public void setmDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isSelected() {
        return isAdded;
    }

    public void setIsSelected(boolean isSelected) {
        this.isAdded = isSelected;
    }

    public String toString() {
        return "('"+mName+"' , "+mPrice+" , '"+mCategory+"' , "+" LOAD_FILE('"+image+"') , '"+mDetails+"')";
    }
    
    private boolean isEq =false;
   public boolean equals(Meal m) {
   
       if( getmName().equalsIgnoreCase(m.getmName()) && getmPrice() == m.getmPrice() && getmCategory().equalsIgnoreCase(m.getmCategory()) && getmDetails().equalsIgnoreCase( m.getmDetails()) )
       {   isEq = true;System.err.println("NO Changes");}
       else
           System.out.println("Changes");
       return isEq;
}
    
}

