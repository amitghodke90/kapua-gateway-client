/*******************************************************************************
 * Copyright (c) 2017 Red Hat Inc and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.gateway.client.utils;

import java.nio.ByteBuffer;

public final class Buffers {

    private Buffers() {
    }

    /**
     * Wrap bytes into a {@link ByteBuffer}, as if they would just haven been put
     * 
     * @param data
     *            the data to use, may be {@code null} or empty
     * @return the new {@link ByteBuffer}, may be {@code null} or empty, if the input is {@code null} or empty
     */
    public static ByteBuffer wrap(final byte[] data) {
        if (data == null) {
            return null;
        }

        final ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.position(buffer.limit());

        return buffer;
    }

    /**
     * Extract the remaining data as a byte array
     * 
     * @param buffer
     *            the input buffer, may be {@code null}
     * @return the output array, may be empty or {@code null} if the input is empty or {@code null}
     */
    public static byte[] toByteArray(final ByteBuffer buffer) {
        if (buffer == null) {
            return null;
        }

        final byte[] byteArray = new byte[buffer.remaining()];
        buffer.get(byteArray);
        return byteArray;
    }
}
