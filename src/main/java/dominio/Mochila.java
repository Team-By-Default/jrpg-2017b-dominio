package dominio;

import java.util.ArrayList;

public class Mochila {
	
	private static final int CANTITEMS = 20;
	private int mochila;
	private int[] items;
	
	public Mochila() {
		items=new int[CANTITEMS];
		for(int i = 0; i < CANTITEMS; i++)
			items[i] = -1;
	}

	/**
	 * Agrega un item en la posicion indicada
	 * @param idItem
	 * @param indice: del vector, posicion donde agregar
	 */
	public void anadirItem(int idItem, int indice) {
		if(indice < 20)
			this.items[indice] = idItem;
	}
	
	/**
	 * Remueve un item con el id indicado
	 * @param idItem
	 */
	public void removerItem(int idItem) {
		boolean removio = false;
		int i=0;
		while(!removio && i<this.items.length) {
			if(this.items[i] == idItem) {
				this.items[i] = -1;
				removio = true;
			}
			i++;
		}
	}
	
	/**
	 * Setea todos los items a partir de un array de Items
	 * @param arrayItems
	 */
	public void setItems(ArrayList<Item> arrayItems) {
		for(int i=0; i<CANTITEMS; i++) {
			if(i < arrayItems.size())
				this.items[i] = arrayItems.get(i).getIdItem();
			else
				this.items[i] = -1;
		}
	}
	
	/**
	 * Saca todos los items
	 */
	public void removerTodos() {
		for(int i=0; i<this.items.length; i++)
			this.items[i]=-1;
	}
	
	/**
	 * Devuelve el item en cierto indice
	 * @param indice
	 * @return
	 */
	public int getItem(int indice) {
		return this.items[indice];
	}
	
	public int getMochila() {
		return mochila;
	}

	public void setMochila(int mochila) {
		this.mochila = mochila;
	}
	
	public int getItem1(){
		return this.items[0];
	}

	public void setItem1(int item){
		this.items[0]=item;
	}

	public int getItem2(){
		return this.items[1];
	}

	public void setItem2(int item){
		this.items[1]=item;
	}

	public int getItem3(){
		return this.items[2];
	}

	public void setItem3(int item){
		this.items[2]=item;
	}

	public int getItem4(){
		return this.items[3];
	}

	public void setItem4(int item){
		this.items[3]=item;
	}

	public int getItem5(){
		return this.items[4];
	}

	public void setItem5(int item){
		this.items[4]=item;
	}

	public int getItem6(){
		return this.items[5];
	}

	public void setItem6(int item){
		this.items[5]=item;
	}

	public int getItem7(){
		return this.items[6];
	}

	public void setItem7(int item){
		this.items[6]=item;
	}

	public int getItem8(){
		return this.items[7];
	}

	public void setItem8(int item){
		this.items[7]=item;
	}

	public int getItem9(){
		return this.items[8];
	}

	public void setItem9(int item){
		this.items[8]=item;
	}

	public int getItem10(){
		return this.items[9];
	}

	public void setItem10(int item){
		this.items[9]=item;
	}

	public int getItem11(){
		return this.items[10];
	}

	public void setItem11(int item){
		this.items[10]=item;
	}

	public int getItem12(){
		return this.items[11];
	}

	public void setItem12(int item){
		this.items[11]=item;
	}

	public int getItem13(){
		return this.items[12];
	}

	public void setItem13(int item){
		this.items[12]=item;
	}

	public int getItem14(){
		return this.items[13];
	}

	public void setItem14(int item){
		this.items[13]=item;
	}

	public int getItem15(){
		return this.items[14];
	}

	public void setItem15(int item){
		this.items[14]=item;
	}

	public int getItem16(){
		return this.items[15];
	}

	public void setItem16(int item){
		this.items[15]=item;
	}

	public int getItem17(){
		return this.items[16];
	}

	public void setItem17(int item){
		this.items[16]=item;
	}

	public int getItem18(){
		return this.items[17];
	}

	public void setItem18(int item){
		this.items[17]=item;
	}

	public int getItem19(){
		return this.items[18];
	}

	public void setItem19(int item){
		this.items[18]=item;
	}

	public int getItem20(){
		return this.items[19];
	}

	public void setItem20(int item){
		this.items[19]=item;
	}
}
