public class RankTile extends Tile{
    protected int rank;

    public RankTile(int rank){
        super();
        this.rank = rank;
        setToolTipText(toString());
    }

    public boolean matches(Tile other){
        if(!super.matches(other))
            return false;
        RankTile otherT = (RankTile) other;
        return this.rank == otherT.rank;
    }
}
//