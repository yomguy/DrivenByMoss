// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2023
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.framework.command.trigger.device;

import de.mossgrabers.framework.command.core.AbstractTriggerCommand;
import de.mossgrabers.framework.configuration.Configuration;
import de.mossgrabers.framework.controller.IControlSurface;
import de.mossgrabers.framework.daw.IModel;
import de.mossgrabers.framework.daw.data.ICursorDevice;
import de.mossgrabers.framework.utils.ButtonEvent;


/**
 * Selects the previous parameter page or device if shifted.
 *
 * @param <S> The type of the control surface
 * @param <C> The type of the configuration
 *
 * @author Jürgen Moßgraber
 */
public class SelectPreviousDeviceOrParamPageCommand<S extends IControlSurface<C>, C extends Configuration> extends AbstractTriggerCommand<S, C>
{
    private final ICursorDevice cursorDevice;


    /**
     * Constructor.
     *
     * @param model The model
     * @param surface The surface
     */
    public SelectPreviousDeviceOrParamPageCommand (final IModel model, final S surface)
    {
        super (model, surface);

        this.cursorDevice = this.model.getCursorDevice ();
    }


    /** {@inheritDoc} */
    @Override
    public void executeNormal (final ButtonEvent event)
    {
        if (event == ButtonEvent.DOWN)
            this.cursorDevice.getParameterBank ().scrollBackwards ();
    }


    /** {@inheritDoc} */
    @Override
    public void executeShifted (final ButtonEvent event)
    {
        if (event == ButtonEvent.DOWN)
            this.cursorDevice.selectPrevious ();
    }


    /**
     * Check if the command can be executed.
     *
     * @return True if it can
     */
    public boolean canExecute ()
    {
        if (this.surface.isShiftPressed ())
            return this.cursorDevice.canSelectPrevious ();
        return this.cursorDevice.getParameterBank ().canScrollBackwards ();
    }
}
