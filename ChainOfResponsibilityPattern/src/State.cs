using System;
using System.Collections.Generic;
using System.Text;

namespace ChainOfResponsibility
{

    abstract class State
    {
        protected AbstractEmployee _employeeContext;

        public void SetContext(AbstractEmployee context)
        {
            this._employeeContext = context;
        }

        public abstract void SetAwaitingState();

        public abstract void SetPreparingState();
    }
}
