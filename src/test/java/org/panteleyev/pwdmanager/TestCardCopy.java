package org.panteleyev.pwdmanager;

/*
 * Copyright (c) Petr Panteleyev. All rights reserved.
 * Licensed under the BSD license. See LICENSE file in the project root for full license information.
 */

import org.panteleyev.pwdmanager.model.Card;
import org.panteleyev.pwdmanager.model.Field;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class TestCardCopy {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
            {Card.newCard(UUID.randomUUID().toString(), Picture.AMEX, List.of(), UUID.randomUUID().toString())},
            {Card.newCard(UUID.randomUUID().toString(), Picture.GLASSES,
                Arrays.asList(
                    new Field(FieldType.STRING, UUID.randomUUID().toString(), UUID.randomUUID().toString()),
                    new Field(FieldType.STRING, UUID.randomUUID().toString(), UUID.randomUUID().toString()),
                    new Field(FieldType.STRING, UUID.randomUUID().toString(), UUID.randomUUID().toString())
                ),
                UUID.randomUUID().toString())
            },
            {Card.newNote(UUID.randomUUID().toString(), UUID.randomUUID().toString(), false)},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testCloneable(Card record) throws Exception {
        var copy = new Card(record);

        Assert.assertEquals(copy, record);
        Assert.assertNotSame(copy, record);
    }
}
