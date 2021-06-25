package ClassDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Class.Orca;

public class OrcaDAO {

	private BufferedWriter bw;
	private BufferedReader br;
	private ArrayList<Orca> orcas;
	private Orca orca;
	private String program = "./bd/orçamentos.csv";
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public ArrayList<Orca> open() {

		orcas = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(program));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] pc = line.split(";");
				orca = new Orca(Integer.valueOf(pc[0]), formato.parse(pc[1]), pc[2], pc[3], Integer.valueOf(pc[4]),
						Integer.valueOf(pc[5]));
				orcas.add(orca);
			}
		} catch (IOException e) {
			System.out.println("Erro ao abrir arquivo: " + e);
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter números: " + e);
		} catch (ParseException e) {
			System.out.println("Erro ao converter datas: " + e);
		}
		return orcas;
	}

	public boolean save(ArrayList<Orca> or) {
		try {
			bw = new BufferedWriter(new FileWriter(program, false));
			for (Orca o : or) {
				bw.write(o.toCSV());
			}
			bw.close();
			return true;
		} catch (IOException e) {
			System.out.println("Erro em gravar o arquivo: " + e);
		}
		return false;

	}
}
