import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class GUI {
	
	private GUI() {
		//  Variável que recebe o valor para ser convertido.
		double valor = 0;
		
		//  Arrays usados para as opções do aplicativo.
		String[] moedaTemperatura = {"Conversor de Moedas", "Conversor de Temperaturas"};
		
		String[] temperatura = {"Fahrenheit para Celsius", "Fahrenheit para Kelvin", 
				"Celsius para Fahrenheint", "Celsius para Kelvin",
				"Kelvin para Celsius", "Kelvin para Fahrenheit"};
		
		String[] moedas = {"Reais a Dólar", "Reais a Euro", "Reais a Libras Esterlinas",
			     "Reais a Peso argentino", "Reais a Peso Chileno", "Dólar a Reais",
			     "Euro a Reais","Libras Esterlinas a Reais", "Peso argentino a  Reais",
			     "Peso Chileno a Reais"};
		
		// Recebe o valor e verifica se é um número.
		try {
			valor = (double) Integer.parseInt(JOptionPane.showInputDialog("Insira o valor a ser convertido"));
		} catch (NumberFormatException ex){
			JOptionPane.showMessageDialog(null, "Insira um valor válido.");
			continuar();
		}
		
		// Opções entre conversão de reais e temperatura.
		String tipo = (String) JOptionPane.showInputDialog(null, 
				"Escolha uma das opções: ", 
				"Conversor de valores", JOptionPane.DEFAULT_OPTION, 
				null, moedaTemperatura, moedaTemperatura[0]);
		
		// Chamar a conversão de de reais ou temperatura, e cuidar com erros.
		if (tipo == "Conversor de Moedas") {	
			String conversaoReais = (String) JOptionPane.showInputDialog(null, 
				"Escolha a conversão desejada: \n O valor das moedas a serem convertidas é de "
			  + "28/02/2023, \n E o resultado é arredondado.", 
				"Conversor de valores", JOptionPane.DEFAULT_OPTION, 
				null, moedas, moedas[0]);
			try {
				converterReais(conversaoReais, valor);
			}catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Insira um valor válido.");
				continuar();
			}			
		}else {
			String conversaoTemperatura = (String) JOptionPane.showInputDialog(null, 
				"Escolha a conversão desejada: ", 
				"Conversor de valores", JOptionPane.DEFAULT_OPTION, 
				null, temperatura, temperatura[0]);
			try {
				converterTemperatura(conversaoTemperatura, valor);
			} catch(NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "Insira um valor válido.");
				continuar();
			}
		}
	}
	
	//  Usa de um switch para fazer a conversão de acordo com o valor pedido
	private void converterReais(String conversaoReais, double valor) {
		switch (conversaoReais) {
		case "Reais a Dólar": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 0.19 + " Dólares");
			continuar();
		case "Reais a Euro": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 0.18 + " Euros");
			continuar();
		case "Reais a Libras Esterlinas": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 0.16 + " Libras Esterlinas");
			continuar();
		case "Reais a Peso argentino": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 37.71 + " Pesos Argentinos");
			continuar();
		case "Reais a Peso Chileno": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 158.91 + " Pesos Chilenos");
			continuar();
		case "Dólar a Reais": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 5.23 + " Reais");
			continuar();
		case "Euro a Reais": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 0.94 + " Reais");
			continuar();
		case "Libras Esterlinas a Reais": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 0.83 + " Reais");
			continuar();
		case "Peso argentino a  Reais": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 197.16 + " Reais");
			continuar();
		case "Peso Chileno a Reais": 
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  valor * 830.86 + " Reais");
			continuar();
		}
	}
	
	//  Usa de um switch para fazer a conversão de acordo com a temperatura pedida.
	private void converterTemperatura(String conversaoTemperatura, double valor) {
		DecimalFormat formatar = new DecimalFormat("#0.00"); 
		switch (conversaoTemperatura) {
		case "Fahrenheit para Celsius":
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  formatar.format((valor - 32) * 5 / 9) + " Graus Celsius.");
			continuar();
		case "Fahrenheit para Kelvin":
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  formatar.format((valor - 32) * 5 / 9 + 273.15) + " Kelvin.");
			continuar();
		case "Celsius para Fahrenheint":
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  formatar.format((valor * 9 / 5) + 32) + " Fahrenheit.");	
			continuar();
		case "Celsius para Kelvin":
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  formatar.format((valor + 273.15)) + " Kelvin.");		
			continuar();
		case "Kelvin para Celsius":
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  formatar.format((valor - 273.15)) + " Graus Celsius.");
			continuar();
		case "Kelvin para Fahrenheit":
			JOptionPane.showMessageDialog(null, "O valor da conversão é de: "
		 +  formatar.format((valor - 273.15) * 9 / 5 + 32) + " Fahrenheit");
			continuar();	
		default:
			continuar();
		}			
	}
	
	// Continua se necessário.
	private void continuar() {
		String[] opcoes = {"Sim", "Não", "Cancelar"};
		
		int resposta = JOptionPane.showOptionDialog(null, "Deseja continuar?", "Conversor de Valores",
					   JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, 
				       null, opcoes, opcoes[0]);
		
		if(resposta == 0) {
			new GUI();
		} else if (resposta == 1) {
			JOptionPane.showMessageDialog(null, "Programa Finalizado.");
			System.exit(0);
		} else {
			JOptionPane.showMessageDialog(null, "Programa Concluído.");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new GUI();
	}
}
