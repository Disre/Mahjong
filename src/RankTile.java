public class RankTile extends Tile{
    protected int rank;

    public RankTile(int rank){
        super();
        this.rank = rank;
        setToolTipText(toString());
    }

    public boolean matches(Tile other){
        RankTile otherTile = (RankTile) other;
        return super.matches(other) && this.rank == otherTile.rank;
    }
}
//