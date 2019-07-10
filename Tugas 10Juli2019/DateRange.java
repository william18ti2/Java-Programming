import java.util.Iterator;
import java.time.LocalDate;
import java.util.NoSuchElementException;

public class DateRange implements Iterable<LocalDate> {
	private LocalDate x, y;
	
	public DateRange(LocalDate x, LocalDate y) {
		this.x = x;
		this.y = y;
	}
	
	public LocalDate getX() {
		return this.x;
	}
	
	public LocalDate getY() {
		return this.y;
	}
	
	public Iterator<LocalDate> iterator() {
		return new DateRangeIterator(getX(), getY());
	}
	
	public boolean contains(LocalDate i) {
		DateRange k = new DateRange(getX(), getY());
		for (LocalDate j: k) {
			if (j.equals(x)) return true;
		}
		return false;
	}
	
	public boolean overlap(DateRange i) {
		DateRange j = new DateRange(getX(),getY());
		if (j.getX().isAfter(i.getY()) || j.getY().isBefore(i.getX())) return false;
		return true;
	}
}

class DateRangeIterator implements Iterator<LocalDate> {
	private LocalDate x,y,z;
	
	public DateRangeIterator(LocalDate x, LocalDate y) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean hasNext() {
		if (this.z.plusDays(1).isAfter(this.y)) return false;
		return true;
	}
	
	public LocalDate next() {
		if (!hasNext()) throw new NoSuchElementException();
		LocalDate z = this.z;
		this.z = this.z.plusDays(1);
		return z;
	}
}