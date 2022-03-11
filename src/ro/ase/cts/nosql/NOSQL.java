package ro.ase.cts.nosql;

import ro.ase.cts.contract.Database;
import ro.ase.cts.contract.ExpressionNOSQL;
import ro.ase.cts.orchestrators.OrchestratorNOSQL;

import java.lang.reflect.InvocationTargetException;

public class NOSQL implements Database {

    @Override
    public void database() {
        try {
            ExpressionNOSQL create = (ExpressionNOSQL) Class.forName("ro.ase.cts.nosql.CreateTable").getDeclaredConstructor().newInstance();
            ExpressionNOSQL insert = (ExpressionNOSQL) Class.forName("ro.ase.cts.nosql.InsertData").getDeclaredConstructor().newInstance();
            ExpressionNOSQL read = (ExpressionNOSQL) Class.forName("ro.ase.cts.nosql.ReadData").getDeclaredConstructor().newInstance();
            OrchestratorNOSQL orchestrator = new OrchestratorNOSQL(create, insert, read);
            orchestrator.execute();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}


