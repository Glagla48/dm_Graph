package utils;

public class KruskalHelper {

    private KruskalHelper parent;
    private int rank;
    public final int name;

    public KruskalHelper(int name)
    {
        this.name = name;
        this.parent = this;
        this.rank = 0;
    }
    public int getRank(){return this.rank;}
    public KruskalHelper getParent(){return this.parent;}


    public void setRank(int r){this.rank = r;}
    public void setParent(KruskalHelper parent){this.parent = parent;}

    @Override
    public int hashCode() {
        
        return super.hashCode() + name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof KruskalHelper)
        {
            KruskalHelper kh = (KruskalHelper) obj;
            return this.name == kh.name;
        }
        return false;
    }


    
}
