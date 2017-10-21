public class CharacterTile extends Tile{
    protected char symbol;

    public CharacterTile(char symbol){
        super();
        this.symbol = symbol;
    }

    public boolean matches(Tile other){
        CharacterTile otherTile = (CharacterTile) other;
        return super.matches(other) && this.symbol == otherTile.symbol;
    }

    @Override
    public String toString() {
        if (Character.isDigit(this.symbol))
            return "Character " + this.symbol;
        else
            switch(this.symbol) {
                case 'N': return "North Wind";

                case 'E': return "East Wind";

                case 'W': return "West Wind";

                case 'S': return "South Wind";

                case 'C': return "Red Dragon";

                case 'F': return "Green Dragon";
            }
        return "oops";
    }
}
