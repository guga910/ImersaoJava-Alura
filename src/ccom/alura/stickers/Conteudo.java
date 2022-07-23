package ccom.alura.stickers;

import java.util.Objects;

public class Conteudo {
	
	private String title;
	private String image;
	
	public Conteudo(String image2, String title2) {
		this.image= image2;
		this.title= title2;
	}
	public Conteudo() {
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	@Override
	public int hashCode() {
		return Objects.hash(image, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conteudo other = (Conteudo) obj;
		return Objects.equals(image, other.image) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Conteudo [title=" + title + ", image=" + image + "]";
	}
	
	

}
