package List;

/**
 * Created by Paca on 4/4/14.
 */
public interface List {
    public Object seeActual();
    public void empty();
    public boolean isEmpty();
    public void insertAfter(Object objectToInsert);
    public void insertBefore(Object objectToInsert);
    public void next();
    public void previous();
    public void goTo(int position);
    public void delete();
    public void modify(Object objectToInsert);

}
