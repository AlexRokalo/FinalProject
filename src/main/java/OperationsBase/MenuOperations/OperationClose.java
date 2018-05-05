package OperationsBase.MenuOperations;

import OperationsBase.Operation;

public class OperationClose implements Operation {

    @Override
    public void execute()  {
        System.exit(0);
    }
}