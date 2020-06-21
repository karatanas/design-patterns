using System;
using System.Collections.Generic;
using System.Text;

namespace ChainOfResponsibility
{
     interface IObserver
    {
         void Update(AbstractEmployee subject);
    }
}
