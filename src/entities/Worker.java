package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
//	Associa��o de Entidades
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
//	M�todos Respos�veis para contratos de Add e Remove.
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		double sum = baseSalary;

//		Instanciando o tipo Calendar (mexer com datas)
//		para separar o m�s e ano.
		Calendar cal = Calendar.getInstance();
		for(HourContract c: contracts) {

//			Dentro do For, (setTime = definirTempo) vai pegar a data guardada em c(for).
//			(c.getTime() = c.ObterTempo) siginifica que naquele momento do for ele obteu
//			a data do contrato existente da lista.
			cal.setTime(c.getDate());
			
//			cal.obter(Calendario. O Ano); 
//			cal.obter(Calendario. O m�s); Em seguida guardar nas mesmas vari�veis.
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
//			Condi��o de verifica��o de datas iguais.
			if( year == c_year && month == c_month) {
//				Soma += c.valorTotal(Classe Criada em entities);
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
