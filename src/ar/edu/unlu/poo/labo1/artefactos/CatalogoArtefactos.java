package ar.edu.unlu.poo.labo1.artefactos;

import java.util.*;

public class CatalogoArtefactos {

    private Set<Artefacto> misArtefactos = new HashSet<>();
    private Map<String, List<Artefacto>> artefactosPorTipo = new HashMap<>();

    public void agregarArtefacto(Artefacto artefacto){

        if(misArtefactos.add(artefacto)){
            if(!artefactosPorTipo.containsKey(artefacto.getTipo())){
                artefactosPorTipo.put(artefacto.getTipo(), new ArrayList<>());
            }
            artefactosPorTipo.get(artefacto.getTipo()).add(artefacto);
        }
    }

    public Set<Artefacto> obtenerArtefactosUnicos(){
        return new HashSet<>(misArtefactos);
    }

    public List<Artefacto> buscarArtefactosPorTipo(String tipo){

        if(!artefactosPorTipo.containsKey(tipo)){
            return new ArrayList<>();
        }
        List<Artefacto> listaArtefactos = new ArrayList<>(artefactosPorTipo.get(tipo));

        listaArtefactos.sort((a, b) -> Integer.compare(b.getPoder(), a.getPoder()));

        return  listaArtefactos;
    }

    public Map<String, Integer> contarArtefactosPorTipo(){

        Map<String, Integer> conteo = new HashMap<>();

        for(Map.Entry<String, List<Artefacto>> entrada: artefactosPorTipo.entrySet()){
            conteo.put(entrada.getKey(), entrada.getValue().size());
        }

        return conteo;
    }

    public Artefacto obtenerArtefactoMasPoderoso(){

        if(misArtefactos.isEmpty()){
            return  null;
        }
        return Collections.max(misArtefactos, Comparator.comparingInt(Artefacto::getPoder));
    }
}
