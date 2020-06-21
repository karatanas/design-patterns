using System;
using System.Collections.Generic;
using System.Text;

namespace ChainOfResponsibility
{
    class CrossborderEmployee : AbstractEmployee
    {
        public override State _state { get; set; } = null;

        private List<IObserver> _observers = new List<IObserver>();


        public CrossborderEmployee(State state)
        {
            this.TransitionTo(state);
        }

        public override void TransitionTo(State state)
        {
            Console.WriteLine($"  Crossborder employee: changed on {state.GetType().Name} state.");
            this._state = state;
            this._state.SetContext(this);
        }

        public override void SetAwaitingState()
        {
            this._state.SetAwaitingState();
        }

        public override void SetPreparingState()
        {
            this._state.SetPreparingState();
        }

        public override bool HandlePackage(object request)
        {
            if ((request as string).Contains("Varna"))
            {
                this.SetPreparingState();
                this.Notify();
                return true;
            }
            else
            {
                return base.HandlePackage(request);
            }
        }
    }
}