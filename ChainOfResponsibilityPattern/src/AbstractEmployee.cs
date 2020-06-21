using System;
using System.Collections.Generic;
using System.Text;

namespace ChainOfResponsibility
{
     abstract class AbstractEmployee : IHandler, ISubject
    {

        private IHandler _nextHandler;

        private List<IObserver> _observers = new List<IObserver>();
        public  abstract State _state { get; set; }

        public abstract void SetAwaitingState();
        public abstract void SetPreparingState();
        public abstract void TransitionTo(State state);

        public void Attach(IObserver observer)
        {
            Console.WriteLine("  " + this.GetType().Name + ": Attached an observer employee.");
            this._observers.Add(observer);
        }

        public void Detach(IObserver observer)
        {
            this._observers.Remove(observer);
            Console.WriteLine("  " + this.GetType().Name + ": Detached an observer.");
        }

        public void Notify()
        {
            Console.WriteLine("  " + this.GetType().Name + ": Notify an observer employee.");

            foreach (var observer in _observers)
            {
                observer.Update(this);
            }
        }

        public IHandler SetNext(IHandler handler)
        {
            this._nextHandler = handler;
            return handler;
        }

        public virtual bool HandlePackage(object request)
        {
            if (this._nextHandler != null)
            {
                return this._nextHandler.HandlePackage(request);
            }
            else
            {
                return false;
            }
        }

     
    }
}
