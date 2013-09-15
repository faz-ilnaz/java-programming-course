public class Magic {
	private int[][] a;
	private int n;

	public Magic(int[][] a) {
		this.a = a;
		this.n = a.length;
	}
	
	public boolean isMagic() {
		return diagonal() && columns() && rows();
	}

	private boolean diagonal() {
		int s1 = 0, s2 = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					s1 += a[i][j];
				if (i == n - j - 1)
					s2 += a[i][j];
			};
		}
		return s1 == s2;
	}

	private boolean columns() {
		int s = 0; 
		int s1 = 0;
		boolean f = true;
        for(int j=0; j<n && f;j++) {
                s1=0;
                for(int i=0; i<n; i++)
                        s1+=a[i][j];
                if(s1!=s && s!=0)
                        f=false;
                s=s1;
        };
        return f;
	}

	private boolean rows() {
		int s = 0;
		int s1 = 0;
		boolean f = true;
        for(int i=0;i<n && f;i++) {
                s1=0;
                for(int j=0;j<n;j++)
                        s1+=a[i][j];
                if(s1!=s && s!=0)
                        f=false;
                s=s1;
        };
        return f;
	}
}
