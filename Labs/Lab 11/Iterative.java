public class Iterative {

	public static BitList complement( BitList in ) {
		BitList x=new BitList();
		Iterator i=in.iterator();
		Iterator o=x.iterator();
		while(i.hasNext()) {
			int y=i.next();
			if(y==BitList.ONE) {
				o.add(BitList.ZERO);
			}
			else if(y==BitList.ZERO) {
				o.add(BitList.ONE);
			}
		}
		return x;
	}

	public static BitList or( BitList a, BitList b ) {
		BitList c=new BitList();
		Iterator i=b.iterator();
		Iterator i2=a.iterator(); 
		Iterator o=c.iterator();
		if (a==null || b==null || a.toString().length() != b.toString().length() || !i.hasNext()){
			throw new IllegalArgumentException();
		}
		while (i.hasNext()){
			int e=i.next();
			int f=i2.next();
			if (e==BitList.ONE || f==BitList.ONE) {
				o.add(BitList.ONE);
			} else {
				o.add(BitList.ZERO);
			}
		}
		return c;
	}

	public static BitList and( BitList a, BitList b ) {
		BitList d=new BitList();
		Iterator i=b.iterator(); 
		Iterator i2=a.iterator();
		Iterator o=d.iterator();
		if (a==null || b==null || a.toString().length()!=b.toString().length() || !i.hasNext()){
			throw new IllegalArgumentException();
		}
		while (i.hasNext()){
			if (i.next()==BitList.ONE && i2.next()==BitList.ONE) {
				o.add(BitList.ONE);
			} else {
				o.add(BitList.ZERO);
			}
		}
		return d;
	}

	public static BitList xor( BitList a, BitList b ) {
		BitList f=new BitList();
		Iterator i=b.iterator();
		Iterator i2=a.iterator(); 
		Iterator o=f.iterator();
		if (a==null || b==null || a.toString().length()!=b.toString().length() || !i.hasNext()){
			throw new IllegalArgumentException();
		}
		while (i.hasNext()){
			int e=i.next();
			int g=i2.next();
			if ((e==BitList.ONE && g==BitList.ZERO)||(e==BitList.ZERO && g==BitList.ONE)) {
				o.add(BitList.ONE);
			} else {
				o.add(BitList.ZERO);
			}
		}
		return f;
	}
}