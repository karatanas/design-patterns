using System;
using System.Collections.Generic;
using System.Text;

namespace ChainOfResponsibility
{
    class PlovdivEmployee : AbstractEmployee
    {
        public override State _state { get; set; } = null;

        public PlovdivEmployee(State state)
        {
            this.TransitionTo(state);
        }

        public override void TransitionTo(State state)
        {
            Console.WriteLine($"  Plovdiv employee: changed on {state.GetType().Name} state.");
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
            if (request.ToString().Contains("Plovdiv"))
            {
                this.SetPreparingState();
                base.Notify();
                return true;
            }
            else
            {
                 return base.HandlePackage(request);
            }
        }
    }
}
