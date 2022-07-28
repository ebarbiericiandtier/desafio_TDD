package produto;

import ingredientes.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Shake {
	private Base base;
	private Fruta fruta;
	private Topping topping;
	private List<Adicional> adicionais;
	private TipoTamanho tipoTamanho;

	public Shake(Base base, Fruta fruta, Topping topping, List<Adicional> adicionais, TipoTamanho tipoTamanho) {
		this.base = base;
		this.fruta = fruta;
		this.topping = topping;
		this.adicionais = adicionais.stream().sorted().collect(Collectors.toList());
		this.tipoTamanho = tipoTamanho;
	}

	public Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho) {
		this.base = base;
		this.fruta = fruta;
		this.topping = topping;
		this.tipoTamanho = tipoTamanho;
		this.adicionais = new ArrayList<Adicional>();
	}

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}

	public Fruta getFruta() {
		return fruta;
	}

	public void setFruta(Fruta fruta) {
		this.fruta = fruta;
	}

	public Topping getTopping() {
		return topping;
	}

	public void setTopping(Topping topping) {
		this.topping = topping;
	}

	public List<Adicional> getAdicionais() {
		return adicionais;
	}

	public void setAdicionais(List<Adicional> adicionais) {
		this.adicionais = adicionais;
	}

	public TipoTamanho getTipoTamanho() {
		return tipoTamanho;
	}

	public void setTipoTamanho(TipoTamanho tipoTamanho) {
		this.tipoTamanho = tipoTamanho;
	}

	@Override
	public String toString() {
		return this.base.getTipoBase().toString() + " / " + this.fruta.getTipoFruta().toString() + " / "
				+ this.topping.getTipoTopping().toString() + " / " + this.adicionais + " / "
				+ this.tipoTamanho.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adicionais == null) ? 0 : adicionais.hashCode());
		result = prime * result + ((base == null) ? 0 : base.hashCode());
		result = prime * result + ((fruta == null) ? 0 : fruta.hashCode());
		result = prime * result + ((tipoTamanho == null) ? 0 : tipoTamanho.hashCode());
		result = prime * result + ((topping == null) ? 0 : topping.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shake other = (Shake) obj;
		if (adicionais == null) {
			if (other.adicionais != null)
				return false;
		} else if (!adicionais.equals(other.adicionais))
			return false;
		if (base == null) {
			if (other.base != null)
				return false;
		} else if (!base.equals(other.base))
			return false;
		if (fruta == null) {
			if (other.fruta != null)
				return false;
		} else if (!fruta.equals(other.fruta))
			return false;
		if (tipoTamanho != other.tipoTamanho)
			return false;
		if (topping == null) {
			if (other.topping != null)
				return false;
		} else if (!topping.equals(other.topping))
			return false;
		return true;
	}

//	public Boolean compareTo(Shake shake) {
//
//		List<Adicional> current = this.adicionais;
//		List<Adicional> neaveuList = shake.getAdicionais();
//
//		if (!shake.getFruta().equals(this.getFruta()))
//			return false;
//		else if (!shake.getBase().equals(this.getBase()))
//			return false;
//		else if (!shake.getTipoTamanho().equals(this.getTipoTamanho()))
//			return false;
//		else if (!shake.getTopping().equals(this.getTopping()))
//			return false;
//		else if (!shake.getFruta().equals(this.getFruta()))
//			return false;
//		else if (!compareAdicionais(current, neaveuList))
//			return false;
//
//		return true;
//	}
//
//	private boolean compareAdicionais(List<Adicional> current, List<Adicional> neaveuList) {
//		if (current.size() != neaveuList.size())
//			return false;
//
//		for (int i = 0; i < current.size(); i++) {
//			if (!current.get(i).equals(current.get(i)))
//				return false;
//		}
//
//		return true;
//
//	}
}
