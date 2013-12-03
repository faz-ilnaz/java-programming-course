package com.kpfu.itis.ticketSystem;

public class TicketWindow {
	
	// "размерность" кинозала
	private int n = 5;

	public int getN() {
		return n;
	}

	private int[][] seatCost = {
			{20, 20, 20, 20, 20},
			{20, 22, 25, 22, 20},
			{20, 25, 25, 25, 20},
			{18, 20, 20, 20, 18},
			{15, 15, 15, 15, 15}
	};
	
	private volatile boolean[][] seatAvailable = new boolean[n][n];
	
	private int totalCash;

	public TicketWindow() {
		for( int i = 0; i < n; i++ ) {
			for( int j = 0; j < n; j++ ) {
				seatAvailable[i][j] = true;
			}
		}
		
		totalCash = 0;
	}
	
	public synchronized boolean buyTicket(int row, int place) {
		
		boolean f = seatAvailable[row][place];
		
		if(f) {
			seatAvailable[row][place] = false;
			totalCash += seatCost[row][place];
		}
		return f;
	}
	/*TODO volatile массив это не то же самое, что массив volatile элементов. Т.е. видимость ссылки seatAvailable гаратнитуется, а видимость элементов seatAvailable - нет. Чтобы поток, который будет вызывать printOccupancy() видел актуальные значения seatAvailable, 
нужно либо сделать метод printOccupancy() synchronized, либо использовать AtomicBoolean[] массив. */
	public void printOccupancy() {
		for( int i = 0; i < n; i++ ) {
			for( int j = 0; j < n; j++ ) {
				System.out.print((seatAvailable[i][j] == false) ? "[x] " : "[ ] ");
			}
			System.out.println();
		}
	}
	
	 public void printTotalCash() {
		 System.out.println("Total cash: " + totalCash);
	 }
	
	
}
