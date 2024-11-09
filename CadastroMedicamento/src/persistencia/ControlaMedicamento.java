package persistencia;

import negocio.Medicamento;

import java.util.ArrayList;

public class ControlaMedicamento {
    private ArrayList<Medicamento>medicamentos = new ArrayList<Medicamento>();
     public  boolean addMedicamento(Medicamento m){
         if (m != null){
             medicamentos.add(m);
             return  true;
         }else{
             return false;
         }
     }

    public  boolean updateMedicamento(Medicamento m, int idx){
        if (m != null){
            medicamentos.set(idx-1, m);
            return  true;
        }else{
            return false;
        }
    }

    public  boolean excluirMedicamento(int index){
        if (index >= 0){
            medicamentos.remove(index-1);
            return  true;
        }else{
            return false;
        }
    }

     public ArrayList<Medicamento>mostrarMedicamento(){
        return medicamentos;
     }

    @Override
    public String toString() {
        return "ControlaMedicamento{" +
                "medicamentos=" + medicamentos +
                '}';
    }
}
