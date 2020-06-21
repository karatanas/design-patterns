using System;
using System.Collections.Generic;
using System.Text;

namespace ChainOfResponsibility
{
    interface IHandler
    {
        IHandler SetNext(IHandler handler);

        bool HandlePackage(object request);
    }
}
