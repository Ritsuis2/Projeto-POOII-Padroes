package classes;

//VOCÊ NÃO DEVE MODIFICAR ESTA CLASSE
public class ImportDataMEC implements IObserver {

    public void update(Object data) {
        //NÃO IREMOS UTILIZAR A LIB ORG.JSON PARA NÃO DEIXAR A TAREFA MAIS COMPLEXA
        //PEGUE A SAIDA A SEGUIR E VALIDE EM: https://jsonformatter.curiousconcept.com
        System.out.println("Atualização recebida: " + data);

    }

    public void importData(String json) {
        System.out.println(json);
    }

}
