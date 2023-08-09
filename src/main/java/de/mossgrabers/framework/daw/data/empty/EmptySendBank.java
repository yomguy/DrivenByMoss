// Written by Jürgen Moßgraber - mossgrabers.de
// (c) 2017-2023
// Licensed under LGPLv3 - http://www.gnu.org/licenses/lgpl-3.0.txt

package de.mossgrabers.framework.daw.data.empty;

import de.mossgrabers.framework.daw.data.ISend;
import de.mossgrabers.framework.daw.data.bank.ISendBank;

import java.util.HashMap;
import java.util.Map;


/**
 * Default data for an empty send bank.
 *
 * @author Jürgen Moßgraber
 */
public class EmptySendBank extends EmptyBank<ISend> implements ISendBank
{
    private static final Map<Integer, EmptySendBank> INSTANCES = new HashMap<> ();


    /**
     * Get an instance of an EmptyParameterBank for the given page size. Instances are cached.
     *
     * @param pageSize The page size for which to get an empty bank
     * @return The bank
     */
    public static EmptySendBank getInstance (final int pageSize)
    {
        return INSTANCES.computeIfAbsent (Integer.valueOf (pageSize), EmptySendBank::new);
    }


    /**
     * Constructor.
     * 
     * @param pageSize The number of elements in a page of the bank
     */
    private EmptySendBank (final int pageSize)
    {
        super (pageSize);
    }


    /** {@inheritDoc} */
    @Override
    public ISend getItem (final int index)
    {
        return EmptySend.INSTANCE;
    }
}